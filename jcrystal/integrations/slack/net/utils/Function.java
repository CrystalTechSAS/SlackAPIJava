package integrations.slack.net.utils;
public interface Function<In, Out>{
	public Out eval(In t);
}
