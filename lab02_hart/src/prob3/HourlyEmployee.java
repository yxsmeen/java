package prob3;

public class HourlyEmployee {
		private String firstName;

		public String getName() {
			return firstName;
		}

		public void setName(String name) {
			this.firstName = name;
		}

		public HourlyEmployee(String name) {
			super();
			this.firstName = name;
		}

		@Override
		public String toString() {
			return "Employee [name=" + firstName + "]";
		}
}
