package amazon.assignment.util;

/**
 * Constructor for the webbasePage that does the check to make sure the page has loaded.
 * @Parmn driver
 * @throws PageNotLoadedException
 */

public abstract class MobileBasePage {
	public abstract void waitForPageLoad();
}
