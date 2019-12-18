package neogrid.distribution.archives;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import neogrid.distribution.enums.ArchivesDirectory;
import neogrid.distribution.enums.ProductType;
import neogrid.distribution.enums.VehicleType;
import neogrid.distribution.main.Main;
import neogrid.distribution.product.Product;
import neogrid.distribution.truck.Truck;

public class FileManipulation {
	
	private static final String[] SUFFIX = {"txt"};
	
	public void readFilesFromDirectory(ArchivesDirectory dir) throws IOException {
		Collection<File> files = FileUtils.listFiles(new File(dir.toString()), SUFFIX, true);
    	for (File file : files) {
    		List<String> contents = FileUtils.readLines(file, StandardCharsets.UTF_8);
    		populateObject(file, dir, contents);
    	}
	}

	private void populateObject(File file, ArchivesDirectory dir, List<String> contents) {
		 if (dir.equals(ArchivesDirectory.PRODUCTS_PATH)) {
			 Product product = new Product();
			 product.setName(FilenameUtils.removeExtension(file.getName()));
			 product.setProductType(ProductType.valueOfProductType(contents.get(0)));
			 product.setWeight(Double.valueOf(contents.get(1)));
			 product.setDestination(contents.get(2));
			 Main.products.add(product);
		 }else if (dir.equals(ArchivesDirectory.VEHICLE_LOADED_PATH)) {
			 Truck truck = new Truck();
			 truck.setPathFilename(file.getPath());
			 truck.setName(FilenameUtils.removeExtension(file.getName()));
			 truck.setVehicleType(VehicleType.valueOfVehicleType(contents.get(0)));
			 truck.setWeight(Double.valueOf(contents.get(1)));
			 truck.setDestination(contents.get(2));
			 Main.trucks.add(truck);
		 }
		
	}
	
	
}
