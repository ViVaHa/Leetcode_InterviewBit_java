class Solution {
    public void getReadings(int lights, int hrs, int minutes, int hrsPassed, int minutesPassed,Set<String> res){
        if(hrs>=12 || minutes>=60){
            return;
        }
            
        if(lights==0){
            StringBuilder builder = new StringBuilder("");
            if(hrs==0){
                builder.append("0");
            }else{
                builder.append(String.valueOf(hrs));
            }
            builder.append(":");
            if(minutes<10){
                builder.append("0");
            }
            builder.append(String.valueOf(minutes));
            res.add(builder.toString());
            return;
        }
        if((hrsPassed>=4 && minutesPassed>=6) || lights<0 || hrs==12){
            return;
        }
        getReadings(lights,hrs,minutes,hrsPassed+1,minutesPassed+1,res);
        if(minutesPassed<6){
            getReadings(lights-1,hrs,minutes+(int)Math.pow(2,minutesPassed),hrsPassed,minutesPassed+1,res);
        }
        if(hrsPassed<4){
            getReadings(lights-1,hrs+(int)Math.pow(2,hrsPassed),minutes,hrsPassed+1,minutesPassed,res);
        }
        
        
    }
    public List<String> readBinaryWatch(int num) {
        int lights=num;
        int hrs=0;
        int minutes=0;
        Set<String> res = new HashSet<>();
        getReadings(lights,hrs,minutes,0,0,res);
        List<String> list = new ArrayList<>(res);
        return list;
    }
}
