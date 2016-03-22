package cs.ss.Design.Pattern;

import cs.ss.Design.Pattern.Builder.User;

public class TestCase {
	public void testBuilder(){
		User user = new User.UserBuilder("json", "zhang")
			.Age(13)
			.Address("dagdsgfds")
			.Phone("21432").build();
	}
}
