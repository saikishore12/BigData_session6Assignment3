package com.acadgild.extend;

//import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
//import org.apache.hadoop.io.Text;
//import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import com.acadgild.TextPair;

public class Partitioner1 extends Partitioner<TextPair,IntWritable> {

	@Override
	public int getPartition(TextPair key,IntWritable values,  int numPartitions) {
	if(key.getFirst().equals(new Text("Samsung"))){
		
		return 0;
		
	}
	else if(key.getFirst().equals(new Text("Onida"))){
		return 1;
	}
	else if(key.getFirst().equals(new Text("Akai"))){
		return 2;
		
	}else if (key.getFirst().equals(new Text("Lava"))){
		return 3;
	}else {
		return 4;
	}
			
	}

}