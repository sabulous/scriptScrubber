/*
 * Muhammed Sabri Sahin
 * 01.04.2019
 * 
 * simple <script>...</script> block remover
 * 
 */

package scriptScrubber;

public class Scrubber {
	
	public static String scrub(String text) {
		if(text == null) return "";
		
		String scrubbedText = text;
		
		String openTag = "<script";
		String closeTag = "</script>";
		
		for(int start = scrubbedText.indexOf(openTag); start != -1; start = scrubbedText.indexOf(openTag)) {
			int end = scrubbedText.indexOf(closeTag) + closeTag.length();
			scrubbedText = scrubbedText.replace(scrubbedText.substring(start, end), "");			
		}
		
		return scrubbedText;
	}

	// example input
	public static void main(String args[]) {
		String text = " Maecenas pulvinar enim tortor, ac gravida tortor molestie vitae."
				+ "Interdum et malesuada fames ac ante ipsum primis in faucibus.  In ac imperdiet mi.\n"
				+ "\nVestibulum mollis, leo <script>et eleifend venenatis\n\n, metus libero fermentum turpis,"
				+ "vitae dignissim quam dui quis lorem.</script> Maecenas et egestas enim. Ut pharetra ipsum ac\n "
				+ "risus laoreet iaculis. Integer vitae\n iaculis neque. Integer sapien " 
				+ "risus, auctor et laoreet id, bibendum vehicula sapien.\n In commodo "
				+ "turpis ac ipsum<script> egestas lobortis.</script>"
				+ "Pellentesque quis diam sapien. Donec quis purus non purus mattis pulvinar sed id arcu.";
		
		System.out.println(Scrubber.scrub(text));
	}
}
