package com.acadgild;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
//import org.apache.hadoop.mapreduce.Reducer.Context;

public class MyReducer extends Reducer<TextPair, IntWritable, TextPair, IntWritable> {

	private static Text textPairText = new Text();
	public void reduce(TextPair key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {

		int NoOfUnits = 0;

		for (IntWritable units : values) {

			NoOfUnits += units.get();
			
		}
		textPairText.set(key.toString());
		context.write(key, new IntWritable(NoOfUnits));
	}
}
