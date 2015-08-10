package cs.ss.Design.Pattern.Singleton;

public class SingletonDoubleChecking {
	private static SingletonDoubleChecking instance;
	
	private SingletonDoubleChecking(){}
	
	public static SingletonDoubleChecking getInstance(){
		if(instance == null){
			synchronized (SingletonDoubleChecking.class) {
				if(instance == null){
					instance = new SingletonDoubleChecking();
				}
			}
		}
		return instance;
	}
}
