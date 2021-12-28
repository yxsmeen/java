package prob4;

public class Worker {
		private String firstName;

		public String getName() {
			return firstName;
		}

		public void setName(String name) {
			this.firstName = name;
		}

		public Worker(String name) {
			super();
			this.firstName = name;
		}

		@Override
		public String toString() {
			return "Employee [name=" + firstName + "]";
		}
}
