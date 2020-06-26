package aula05_TakeAway;

public abstract class Container {
	protected Commodity commodity;
	
	public boolean placeCommodity(Commodity c) {
		this.commodity = c;
		return true;
	}
}

	class PlasticBottle extends Container{
		public String toString() {
			return String.format("PlasticBottle [%s]", super.commodity.toString());
		}
	};
	
	class TermicBottle extends Container{
		public String toString() {
			return String.format("TermicBotle [%s]", super.commodity.toString());
		}
	};
	
	class Tupperware extends Container{
		public String toString() {
			return String.format("Tupperware [%s]", super.commodity.toString());
		}
	};
	
	class PlasticBag extends Container{
		public String toString() {
			return String.format("PlasticBag [%s]", super.commodity.toString());
		}
	};