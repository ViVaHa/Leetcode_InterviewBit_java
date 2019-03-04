class Solution {
    public void getAllKilledProcesses(Map<Integer, List<Integer>>map,int kill, List<Integer> killedProcesses){
        killedProcesses.add(kill);
        if(map.containsKey(kill)){
            for(Integer child : map.get(kill)){
                getAllKilledProcesses(map,child,killedProcesses);
            }
        }
        
    }
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        if(kill==0){
            return pid;    
        }
        for(int i=0;i<pid.size();i++){
            List<Integer> children;
            if(map.containsKey(ppid.get(i))){
                children = map.get(ppid.get(i));
            }else{
                children = new ArrayList<>();
            }
            children.add(pid.get(i));
            map.put(ppid.get(i),children);
        }
        List<Integer> killedProcesses = new ArrayList<>();
        getAllKilledProcesses(map,kill,killedProcesses);
        return killedProcesses;
    }
}
