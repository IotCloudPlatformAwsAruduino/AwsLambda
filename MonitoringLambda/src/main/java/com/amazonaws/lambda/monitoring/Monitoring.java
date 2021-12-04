package com.amazonaws.lambda.monitoring;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Monitoring implements RequestHandler<Object, String> {
	int air=0;
	@Override
	public	String	handleRequest(Object	input,	Context	context) {
					context.getLogger().log("Input:	" +	input);
					String	json	= ""+input;
					JsonParser	parser	= new JsonParser();
					JsonElement	element	=	parser.parse(json);
					JsonElement	state	=	element.getAsJsonObject().get("state");
					JsonElement	reported	=	state.getAsJsonObject().get("reported");
					String	temperature	=	reported.getAsJsonObject().get("temperature").getAsString();
					String humidity	=	reported.getAsJsonObject().get("humidity").getAsString();
					
				
					double	temp	=	Double.valueOf(temperature);
					double hum = Double.valueOf(humidity); 
					final	String	AccessKey="AKIA3EYBCJ2VFJQAITPU";
					final	String	SecretKey="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";
					final	String	topicArn="arn:aws:sns:ap-northeast-2:766117039786:temerature_warning_topic";
					BasicAWSCredentials	awsCreds	= new BasicAWSCredentials(AccessKey,SecretKey);		
					AmazonSNS	sns	=	AmazonSNSClientBuilder.standard()
																	.withRegion(Regions.AP_NORTHEAST_2)
																	.withCredentials( new AWSStaticCredentialsProvider(awsCreds) )
																	.build();
					final	String	msg	= "*Temperature	Critical*\n" + "Your	device	temperature	is	" +	temp	+ "C      "     +hum     +   "%";
					final	String	subject	= "Starting Air Conditional";
					final	String	sub	= "Stop Air Conditional";
					
					if ((hum > 36.0 || temp > 29.0) &&air == 0) {
									PublishRequest	publishRequest	= new PublishRequest(topicArn,	msg,	subject);
									PublishResult	publishResponse	=	sns.publish(publishRequest);
									air = 1;
					}
					if((hum <= 36.0 && temp <= 29.0) &&air == 1){
						PublishRequest	publishRequest	= new PublishRequest(topicArn,	msg,	sub);
						PublishResult	publishResponse	=	sns.publish(publishRequest);
						air = 0;
		}
					
					return	subject+ "temperature	=	" +	temperature	+ "!";
	}
}
