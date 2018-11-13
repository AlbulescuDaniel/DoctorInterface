package entity;

public class Medicament {
	    private String name;
	    private String description;
	    private String fabricant;
	    private String activeComponent;
		
		public Medicament() {
			super();
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getFabricant() {
			return fabricant;
		}
		public void setFabricant(String fabricant) {
			this.fabricant = fabricant;
		}
		public String getActiveComponent() {
			return activeComponent;
		}
		public void setActiveComponent(String activeComponent) {
			this.activeComponent = activeComponent;
		}
		
		public Medicament(String name, String description, String fabricant,
				String activeComponent) {
			super();
			this.name = name;
			this.description = description;
			this.fabricant = fabricant;
			this.activeComponent = activeComponent;
		}
		@Override
		public String toString() {
			return "Medicament [name=" + name + ", description=" + description + ", fabricant=" + fabricant
					+ ", activeComponent=" + activeComponent + "]";
		}
		
		
}
