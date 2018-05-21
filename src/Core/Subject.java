package Core;

public abstract class Subject {
	String name;
	
	public Subject(String sName) {
		this.name = sName;
	}
	
	public String getName() {
		return this.name;
	}
	
	private static String toCamelCase(final String init) {
	    if (init==null)
	        return null;

	    final StringBuilder ret = new StringBuilder(init.length());

	    for (final String word : init.split(" ")) {
	        if (!word.isEmpty()) {
	            ret.append(word.substring(0, 1).toUpperCase());
	            ret.append(word.substring(1).toLowerCase());
	        }
	        if (!(ret.length()==init.length()))
	            ret.append(" ");
	    }

	    return ret.toString();
	}
	
	public String toString() {
		return toCamelCase(this.name);
	}
}
