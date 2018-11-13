package entity;

public class PharmacyStock {
	private int pharmacyId;
	private int medicamentId;
	private double price;
	private int quantity;
	public int getPharmacyId() {
		return pharmacyId;
	}
	public void setPharmacyId(int pharmacyId) {
		this.pharmacyId = pharmacyId;
	}
	public int getMedicamentId() {
		return medicamentId;
	}
	public void setMedicamentId(int medicamentId) {
		this.medicamentId = medicamentId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public PharmacyStock() {
		super();
	}
	public PharmacyStock(int pharmacyId, int medicamentId, double price, int quantity) {
		super();
		this.pharmacyId = pharmacyId;
		this.medicamentId = medicamentId;
		this.price = price;
		this.quantity = quantity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + medicamentId;
		result = prime * result + pharmacyId;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PharmacyStock other = (PharmacyStock) obj;
		if (medicamentId != other.medicamentId)
			return false;
		if (pharmacyId != other.pharmacyId)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
}
