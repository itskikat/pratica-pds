package aula12_ex01;

public class PluginNumbers implements IPlugin {

	@Override
	public void fazQualQuerCoisa() {
		System.out.println("COUNTDOWN");
		for (int i = 0; i <= 10; i++)
			System.out.println(i);
	
	}

}
