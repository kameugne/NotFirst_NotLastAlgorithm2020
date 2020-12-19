import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by vincent on 2017-01-30.
 */
public class EvaluationPetitExample {
	
    public static void main(String[] args) throws Exception
    {
        boolean found = false;
        int C = 6;
        int n = 10;
        
        for (int i=0; i<900000000; i++)
        {
            Task[] tasks = TaskGenerator.generateCumulativeTaks(n, 0, 15, C);
            EdgeFinder ef = new EdgeFinder(tasks, C);
            //ThetaTreeNotFirst tt = new ThetaTreeNotFirst(tasks, C);
            TimeLineNotFirst tl = new TimeLineNotFirst(tasks, C);
            HorizontallyNotFirst he = new HorizontallyNotFirst(tasks, C);
            HorizontallyEdgeFinder hef = new HorizontallyEdgeFinder(tasks, C);

            
            //int[] estTT = tt.filterWithTimeline();
            int[] estTL = tl.filterWithTimeline();
            int[] estHE = he.Filter();
            int[] estHEF = hef.Filter();
            int[] est = ef.Filter();
            boolean validInstance = true;
            if(!ef.OverloadCheck())
            {
                validInstance = false;
            }
            else
            {
                for(int l=0; l < tasks.length; l++){
                    if( estHEF[l] > tasks[l].earliestStartingTime() || estHEF[l] + tasks[l].processingTime() > tasks[l].latestCompletionTime()){
                    	validInstance = false;
                        break;
                    }
                    if( est[l] + tasks[l].processingTime() > tasks[l].latestCompletionTime()){
                    	validInstance = false;
                        break;
                    }
                    /*if(estHE[l] > tasks[l].earliestStartingTime() || estHE[l] + tasks[l].processingTime() > tasks[l].latestCompletionTime()){
                    	validInstance = false;
                        break;
                    }*/
                    /*if(estTT[l] > tasks[l].earliestStartingTime() || estTT[l] + tasks[l].processingTime() > tasks[l].latestCompletionTime()){
                    	validInstance = false;
                        break;
                    }*/
                }

                for(int t=0; t<=15; t++)
                {
                    int h = 0;
                    for(int l=0; l < tasks.length; l++){
                        if(t >= tasks[l].latestStartingTime() && t < tasks[l].earliestCompletionTime())
                            h+=tasks[l].height();
                    }
                    if(h > C)
                    {
                        validInstance = false;
                        break;
                    }
                    
                    for(int k = 0; k < tasks.length; k++){
                    	int TT  = 0;
                    	for(int l = 0; l < tasks.length; l++){
                    		if(k != l && t >= tasks[l].latestStartingTime() && t < tasks[l].earliestCompletionTime())
                    			TT += tasks[l].height();
                    	}
                    	if(t < tasks[k].earliestCompletionTime() && tasks[k].height() + TT > C)
                    	{
                    		validInstance = false;
                            break;
                    	}
                    }
                }
            }

            for(int j=0; j < n; j++)
            {
                if(validInstance && est[j] > estHEF[j] && estHEF[j] != 0)
                {
                    for(int k=0; k<tasks.length; k++)
                    {
                        System.out.println("k = " + k + "  : " + tasks[k].toString());
                    }
                    System.out.println("Gingras Horizontally Edge Finder : " + Arrays.toString(est));
                    System.out.println("Fetgo Horizontally Edge Finder : " + Arrays.toString(estHEF));
                    System.out.println("C = " + C);
                    System.out.println("i = " + j);
                    System.out.println("Gingras Horizontally Edge Finder : " + est[j]);
                    System.out.println("Fetgo Horizontally Edge Finder :" + estHEF[j]);
                    found = true;
                    break;
                }
            }
            if(found)
                break;
        }
    }
}
