package com.acadgild.extend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;
import com.acadgild.TextPair;

public class MyReducer1 extends Reducer<TextPair, IntWritable, TextPair, IntWritable> {

	public void reduce(TextPair key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		ArrayList<IntWritable> tempArray = new ArrayList<IntWritable>();
		tempArray.clear();
		for (IntWritable value : values) {
			tempArray.add(new IntWritable(value.get()));
		}
		Collections.sort(tempArray, new Comparator<IntWritable>() {

			@Override
			public int compare(IntWritable val1, IntWritable val2) {

				return (-1) * (val2.get() - val1.get());
			}
		});
		int endIndex = 3;
		if (tempArray.size() < 3) {
			endIndex = tempArray.size();
		}
		for (int i = 0; i < endIndex; i++) {
			context.write(key, tempArray.get(i));
		}
	}
}
