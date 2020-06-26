package aula05_TakeAway;

public interface Commodity {
	public Temperature getTemperature();
	public State getState();
	public String toString();
}

	class Milk implements Commodity{
		private State state = State.Liquid;
		private Temperature temperature = Temperature.WARM;
		private String others;

		public Temperature getTemperature() {
			return this.temperature;
		}
		public State getState() {
			return this.state;
		}
		
		public String toString() {
			String out = "";
			out+="[commodity=Milk " + "[Temperature()=" + this.temperature + ", State()=" + this.state + "]]";
			return String.format("commodity=Milk [Temperature()=%s, State()=%s]]", this.temperature, this.state);
		}
	}
	
	class FruitJuice implements Commodity{
		private State state = State.Liquid;
		private Temperature temperature = Temperature.COLD;
		private String others = "Orange";

		public Temperature getTemperature() {
			return this.temperature;
		}
		public State getState() {
			return this.state;
		}
		
		public String toString() {
			return String.format("commodity=Pork [fruit= %s, Temperature()=%s, State()=%s]]", this.others, this.temperature, this.state);
		}
	}
	
	class Tuna implements Commodity{
		private State state = State.Solid;
		private Temperature temperature = Temperature.COLD;
		private String others;

		public Temperature getTemperature() {
			return this.temperature;
		}
		public State getState() {
			return this.state;
		}
		
		public String toString() {
			return String.format("commodity=Tuna [Temperature()=%s, State()=%s]]", this.temperature, this.state);
		}
	}
	
	class Pork implements Commodity{
		private State state = State.Solid;
		private Temperature temperature = Temperature.WARM;
		private String others;

		public Temperature getTemperature() {
			return this.temperature;
		}
		public State getState() {
			return this.state;
		}
		
		public String toString() {
			return String.format("commodity=Pork [Temperature()=%s, State()=%s]]", this.temperature, this.state);
		}
	}

