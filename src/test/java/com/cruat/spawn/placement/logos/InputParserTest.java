package com.cruat.spawn.placement.logos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.Test;


public class InputParserTest {

	@Test
	public void test() throws IOException {
		StringBuilder builder = new StringBuilder();
		builder.append("5,6,7,8,9").append("\n");
		builder.append("0,1,2,3,4").append("\n");
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(outStream);
		osw.write(builder.toString());
		osw.flush();
		
		byte[] bArr = outStream.toByteArray();
		ByteArrayInputStream inStream = new ByteArrayInputStream(bArr);
		
		try(InputParser parser = new InputParser(inStream)){
			int[][] result = parser.getContent();
			
			assertThat(result.length, equalTo(2));
			assertThat(result[0].length, equalTo(5));
			assertThat(result[1].length, equalTo(5));
			
			assertThat(result[0][0], equalTo(5));
			assertThat(result[0][1], equalTo(6));
			assertThat(result[0][2], equalTo(7));
			assertThat(result[0][3], equalTo(8));
			assertThat(result[0][4], equalTo(9));
			
			assertThat(result[1][0], equalTo(0));
			assertThat(result[1][1], equalTo(1));
			assertThat(result[1][2], equalTo(2));
			assertThat(result[1][3], equalTo(3));
			assertThat(result[1][4], equalTo(4));
		}
	}
}
