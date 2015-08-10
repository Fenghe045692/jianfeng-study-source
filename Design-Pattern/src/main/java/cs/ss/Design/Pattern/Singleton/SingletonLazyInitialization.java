package cs.ss.Design.Pattern.Singleton;

//lazy initialization when needed
public class SingletonLazyInitialization {
	private SingletonLazyInitialization(){}
	
	private static class SingleTonHelperClass{
		private static final SingletonLazyInitialization INSTSNCE = new SingletonLazyInitialization();
	}
	
	public static SingletonLazyInitialization getInstance(){
		return SingleTonHelperClass.INSTSNCE;
	}
}
