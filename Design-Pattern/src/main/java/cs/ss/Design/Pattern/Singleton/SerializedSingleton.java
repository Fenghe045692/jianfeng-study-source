package cs.ss.Design.Pattern.Singleton;

import java.io.Serializable;

public class SerializedSingleton implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7604766932017737115L;

	private SerializedSingleton(){}
	
	private static class SingleTonHelperClass{
		private static final SerializedSingleton INSTSNCE = new SerializedSingleton();
	}
	
	public static SerializedSingleton getInstance(){
		return SingleTonHelperClass.INSTSNCE;
	}
	
	//overcome destroy singleton design pattern
	protected Object readResolve() {
	    return getInstance();
	}
}
