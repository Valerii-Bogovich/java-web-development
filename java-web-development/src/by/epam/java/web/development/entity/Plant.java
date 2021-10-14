package by.epam.java.web.development.entity;

public abstract class Plant {
	private int id;
	private double height;
	
	
	public Plant(int id, double height) {
		
		this.id = id;
		this.height = height;
	}



	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}


	
	public double getHeight() {
		return height;
	}



	public void setHeight(double height) {
		this.height = height;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Plant other = (Plant) obj;
		if (id != other.id)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Plant :  id= " + id + ", height=" + height ;
	}



	
	
	
	
	
}
