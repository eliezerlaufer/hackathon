package neogrid.distribution.enums;

public enum ArchivesDirectory {
	PRODUCTS_PATH("C:\\folder_distribution\\produtos_aguardando"),
	DOCKS_PATH("C:\\folder_distribution\\docas"),
	VEHICLE_LOADED_PATH("C:\\folder_distribution\\veiculo_entrada"),
	VEHICLE_UNLOADED_PATH("C:\\folder_distribution\\veiculo_saida");
	
	private String folderPath;
	
	public String getFolderPath() {
		return folderPath;
	}

	private ArchivesDirectory(String folderPath) {
		this.folderPath = folderPath;
	}
	
	public static ArchivesDirectory valueOfFolderPath(String folderPath) {
		for (ArchivesDirectory arcDir : values()) {
            if (arcDir.folderPath.equals(folderPath)) {
                return arcDir;
            }
        }
        return null;
	}
	
	@Override
    public String toString() {
        return this.folderPath;
    }
}
