package neogrid.distribution.main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import neogrid.distribution.archives.FileManipulation;
import neogrid.distribution.enums.ArchivesDirectory;
import neogrid.distribution.product.Product;
import neogrid.distribution.truck.Truck;

public class Main {
	
	public static List<Product> products = new ArrayList<>();
	public static List<Truck> trucks = new ArrayList<>();
	
	private static final String PIPELINE = "|";
	
	public static void main( String[] args ) throws IOException {
    	
		FileManipulation fileManipulation = new FileManipulation();
		fileManipulation.readFilesFromDirectory(ArchivesDirectory.PRODUCTS_PATH);
		fileManipulation.readFilesFromDirectory(ArchivesDirectory.VEHICLE_LOADED_PATH);
    	
		for (Truck truck : trucks) {
			
			/*
			System.out.println("CAMINHAO NAME - "+ truck.getName());
			System.out.println("CAMINHAO PRODUCT TYPE - "+ truck.getVehicleType());
			System.out.println("CAMINHAO PESO - "+ truck.getWeight());
			System.out.println("CAMINHAO DESTINATION - "+ truck.getDestination());
			*/
			
			for (Product product : products) {				
				if (truck.getDestination().equals(product.getDestination()) && truck.getVehicleType().equals(product.getProductType())) {
					
					//coloca na doca
					Path vehicleEntry = Paths.get(truck.getPathFilename());
					Path vechicleDock = Paths.get(ArchivesDirectory.DOCKS_PATH.getFolderPath());
					Path vechicleOut = Paths.get(ArchivesDirectory.VEHICLE_UNLOADED_PATH.getFolderPath());
					
					Files.move(vehicleEntry, vechicleDock, StandardCopyOption.REPLACE_EXISTING);
					
					//carrega e altera arquivo
					StringBuilder sBuild = new StringBuilder();
					sBuild.append(product.getName()+PIPELINE);
					sBuild.append(product.getProductType()+PIPELINE);
					sBuild.append(product.getWeight()+PIPELINE);
					sBuild.append(product.getDestination());

					List<String> lines = Arrays.asList(sBuild.toString());
					Path file = Paths.get(truck.getPathFilename());
					Files.write(file, lines, StandardCharsets.UTF_8);
					
					//saida
					Files.move(vechicleDock, vechicleOut, StandardCopyOption.REPLACE_EXISTING);
				}
			}
		}
    }
}
