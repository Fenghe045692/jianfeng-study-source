package cs.ss.Design.Pattern.Singleton;

public class SingletonStaticInitialization {
	private static SingletonStaticInitialization instance = new SingletonStaticInitialization();
	
	private SingletonStaticInitialization(){}
	
	public static SingletonStaticInitialization getInstance(){
		return instance;
	}
}
