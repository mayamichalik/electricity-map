
public class testSep {
	DLList<String> dlinkedList = new DLList<String>();
	boolean testPassed;
	String s;
	public static void main(String[] args) {
		DLList<String> dlinkedList = new DLList<String>();
		boolean testPassed;
		String s;
		
	testPassed = true;

	// Test 4: insert, changeValue
			// ----------------------
			dlinkedList = new DLList<String>();
			testPassed = true;
			try {
				for (int i = 1000; i > 700; --i)
					dlinkedList.insert("data" + i, i);
				for (int i = 400; i <= 700; ++i)
					dlinkedList.insert("data" + i, i);
				for (int i = 399; i > 0; --i)
					dlinkedList.insert("data" + i, i);

				for (int i = 1; i <= 20; ++i) {
					dlinkedList.changeValue("data" + i, 100 + i);
				}

				s = dlinkedList.getSmallest();
				if (!s.equals("data21"))
					testPassed = false;
			} catch (Exception e) {
				testPassed = false;
			}

			try {
				dlinkedList.changeValue("data0", 0);
				testPassed = false;
			} catch (InvalidDataItemException e) {
			}

			if (testPassed)
				System.out.println("Test 4 passed");
			else
				System.out.println("Test 4 failed");

	}
		
}
