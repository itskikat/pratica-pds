package aula05_UniversityLunch;

interface LunchBuilder {
	public void buildDrink();
	public void buildMainCourse();
	public void buildSide();
	public Lunch getMeal();
}

	class CastroLunchBuilder implements LunchBuilder {
		protected Lunch lunch = new Lunch();
		
		public void buildDrink() {
			lunch.setDrink("Vinho Tinto");
		}
		public void buildMainCourse() {
			lunch.setMainCourse("Bacalhau a lagareiro");
		}
		public void buildSide() {
			lunch.setSide("Broa");
		}
		
		public Lunch getMeal() {
			return lunch;
		}
	}
	
	class SnackLunchBuilder implements LunchBuilder {
		protected Lunch lunch = new Lunch();
		
		public void buildDrink() {
			lunch.setDrink("Sumo");
		}
		public void buildMainCourse() {
			lunch.setMainCourse("Pao com Panado");
		}
		public void buildSide() {
			lunch.setSide("Rissol");
		}
		
		public Lunch getMeal() {
			return lunch;
		}
	}
	
	class CentralCantineLunchBuilder implements LunchBuilder {
		protected Lunch lunch = new Lunch();
		
		public void buildDrink() {
			lunch.setDrink("Agua");
		}
		public void buildMainCourse() {
			lunch.setMainCourse("Grelhada mista");
		}
		public void buildSide() {
			lunch.setSide("Queijo fresco");
		}
		
		public Lunch getMeal() {
			return lunch;
		}
	}