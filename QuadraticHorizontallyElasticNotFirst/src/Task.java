import java.util.Comparator;

class Task implements Comparable<Task> {
    // attributes of a task
    private int id;
    private int est;
    private int lct;
    private int p;
    private int height;

    public int tempEst;
    //Attributes used to map the time attributes of a task to timepoints on the Profile (see Profile.java)
    public Timepoint est_to_timepoint;
    public Timepoint ect_to_timepoint;
    public Timepoint lct_to_timepoint;

    public boolean inLambda;

    public Task(int id, int est, int lct, int p, int h){
        this.id = id;
        this.est = est;
        this.tempEst = est;
        this.lct = lct;
        this.p = p;
        this.height = h;
    }
    public Task(Task t) {
        this.id = t.id();
        this.est = t.est;
        this.tempEst = t.tempEst;
        this.lct = t.lct;
        this.p = t.p;
        this.height = t.height;
    }
    public int earliestStartingTime() {
        return est;
    }
    public int latestCompletionTime() {
        return lct;
    }
    public int processingTime() {
        return p;
    }
    public int earliestCompletionTime() {
        return est + p;
    }
    public int latestStartingTime() {
        return lct - p;
    }
    public int height() {
        return height;
    }
    public int energy() {
        return height * p;
    }
    public int envelop(int C){
        return C * earliestStartingTime() + energy();
    }
    public static class ComparatorByEst implements Comparator<Integer> {
        private  Task[] tasks;
        public ComparatorByEst( Task[] list_of_tasks) {
            this.tasks = list_of_tasks;
        }
        @Override
        public int compare(Integer a, Integer b) {
            return tasks[a].earliestStartingTime() - tasks[b].earliestStartingTime();
        }
    }
    public static class ComparatorByHeight implements Comparator<Integer> {
        private  Task[] tasks;
        public ComparatorByHeight( Task[] list_of_tasks) {
            this.tasks = list_of_tasks;
        }
        @Override
        public int compare(Integer a, Integer b) {
            return tasks[a.intValue()].height() - tasks[b.intValue()].height();
        }
    }
    public static class ComparatorByHeight_ReverseEst implements Comparator<Integer> {
        private  Task[] tasks;
        public ComparatorByHeight_ReverseEst( Task[] list_of_tasks) {
            this.tasks = list_of_tasks;
        }
        @Override
        public int compare(Integer a, Integer b) {
            if(tasks[a].height() == tasks[b].height()) {
                return tasks[b].earliestStartingTime() - tasks[a].earliestStartingTime();
            }
            else {
                return tasks[a].height() - tasks[b].height();
            }
        }
    }
    public static class ComparatorByLct implements Comparator<Integer> {
        private  Task[] tasks;
        public ComparatorByLct( Task[] list_of_tasks) {
            this.tasks = list_of_tasks;
        }
        @Override
        public int compare(Integer a, Integer b) {
            return tasks[a.intValue()].latestCompletionTime() - tasks[b.intValue()].latestCompletionTime();
        }
    }
    public static class ComparatorByEct implements Comparator<Integer> {
        private Task[] tasks;
        public ComparatorByEct(Task[] list_of_tasks) {
            this.tasks = list_of_tasks;
        }
        @Override
        public int compare(Integer a, Integer b) {
            return tasks[a].earliestCompletionTime() - tasks[b].earliestCompletionTime();
        }
    }
    public static class ComparatorByLst implements Comparator<Integer> {
        private  Task[] tasks;
        public ComparatorByLst( Task[] list_of_tasks) {
            this.tasks = list_of_tasks;
        }
        @Override
        public int compare(Integer a, Integer b) {
            return tasks[a].latestStartingTime() - tasks[b].latestStartingTime();

        }
    }

    public static class ComparatorByLctReverseEst implements Comparator<Integer> {
        private  Task[] tasks;
        public ComparatorByLctReverseEst( Task[] list_of_tasks) {
            this.tasks = list_of_tasks;
        }
        @Override
        public int compare(Integer a, Integer b) {
            if (tasks[a.intValue()].latestCompletionTime() == tasks[b.intValue()].latestCompletionTime()) {
                return tasks[b.intValue()].earliestStartingTime() - tasks[a.intValue()].earliestStartingTime();
            }else {
                return tasks[a.intValue()].latestCompletionTime() - tasks[b.intValue()].latestCompletionTime();
            }
        }
    }

    public static class ComparatorByLctByEstReverseHeightReverseEct implements Comparator<Integer> {
        private  Task[] tasks;
        public ComparatorByLctByEstReverseHeightReverseEct( Task[] list_of_tasks) {

            this.tasks = list_of_tasks;
        }
        @Override
        public int compare(Integer a, Integer b){
            if(tasks[a.intValue()].latestCompletionTime() == tasks[b.intValue()].latestCompletionTime())
            {
                if(tasks[b.intValue()].earliestStartingTime() == tasks[a.intValue()].earliestStartingTime())
                {
                    if(tasks[a.intValue()].height == tasks[b.intValue()].height)
                        return tasks[b.intValue()].earliestCompletionTime() - tasks[a.intValue()].earliestCompletionTime();
                    else
                        return tasks[b.intValue()].height - tasks[a.intValue()].height;
                }else{
                    return tasks[a.intValue()].earliestStartingTime() - tasks[b.intValue()].earliestStartingTime();
                }
            }else{
                return tasks[a.intValue()].latestCompletionTime() - tasks[b.intValue()].latestCompletionTime();
            }

        }
    }

    public static class ComparatorByLctByEstByReverseHeightByReverseEct implements Comparator<Integer> {
        private  Task[] tasks;
        public ComparatorByLctByEstByReverseHeightByReverseEct( Task[] list_of_tasks) {

            this.tasks = list_of_tasks;
        }
        @Override
        public int compare(Integer a, Integer b){
            if(tasks[a.intValue()].latestCompletionTime() == tasks[b.intValue()].latestCompletionTime())
            {
                if(tasks[b.intValue()].earliestStartingTime() == tasks[a.intValue()].earliestStartingTime())
                {
                    if(tasks[a.intValue()].height == tasks[b.intValue()].height)
                        return tasks[b.intValue()].earliestCompletionTime() - tasks[a.intValue()].earliestCompletionTime();
                    else
                        return tasks[b.intValue()].height - tasks[a.intValue()].height;
                }else{
                    return tasks[a.intValue()].earliestStartingTime() - tasks[b.intValue()].earliestStartingTime();
                }
            }else{
                return tasks[a.intValue()].latestCompletionTime() - tasks[b.intValue()].latestCompletionTime();
            }

        }
    }


    public static class ComparatorByLctReverseEstByHeightByEct implements Comparator<Integer> {
        private  Task[] tasks;
        public ComparatorByLctReverseEstByHeightByEct( Task[] list_of_tasks) {

            this.tasks = list_of_tasks;
        }
        @Override
        public int compare(Integer a, Integer b){
            if(tasks[a.intValue()].latestCompletionTime() == tasks[b.intValue()].latestCompletionTime())
            {
                if(tasks[b.intValue()].earliestStartingTime() == tasks[a.intValue()].earliestStartingTime())
                {
                    if(tasks[a.intValue()].height == tasks[b.intValue()].height)
                        return tasks[a.intValue()].earliestCompletionTime() - tasks[b.intValue()].earliestCompletionTime();
                    else
                        return tasks[a.intValue()].height - tasks[b.intValue()].height;
                }else{
                    return tasks[b.intValue()].earliestStartingTime() - tasks[a.intValue()].earliestStartingTime();
                }
            }else{
                return tasks[a.intValue()].latestCompletionTime() - tasks[b.intValue()].latestCompletionTime();
            }

        }
    }
    public void setEarliestStartingTime(int est) {
        this.est = est;
    }

    public void setEarliestStartingTimeWithCheck(int est) {
        if(est > this.est)
            this.est = est;
    }
    public void setLatestCompletionTime(int lct) {
        this.lct = lct;
    }
    public void setProcessingTime(int p) {
        this.p = p;
    }
    public int id(){
        return id;
    }
    public boolean isConsistent() {
        return (est + p == lct);
    }
    public boolean hasFixedPart() {
        return (lct - p < est + p);
    }
    @Override
    public int compareTo(Task o) {
        return this.est > o.est ? 1 : this.est < o.est ? -1 : 0;
    }

    @Override
    public String toString() {
        return "Task: (est = " + this.est + ", lct = " + this.lct + ", p = " + this.p + ", h = " + this.height  + ")";
    }
}
