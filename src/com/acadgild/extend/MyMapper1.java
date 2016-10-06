package com.acadgild.extend;

import java.io.IOException;

//import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
///import org.apache.hadoop.io.Text;
//import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.acadgild.TextPair;

public class MyMapper1 extends Mapper<TextPair,IntWritable,TextPair,IntWritable>{

	public void map(TextPair key,IntWritable value,Context context) throws IOException, InterruptedException{
		
		context.write(key,value);
		
	}
}