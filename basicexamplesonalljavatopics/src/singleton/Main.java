package singleton;

class Main {
	   public static void main(String[] args) {
	      Database db1;

	      // refers to the only object of Database
	      db1= Database.getInstance();
	      
	      db1.getConnection();
	   }
	}

