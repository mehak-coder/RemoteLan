
//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.Unirest;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class Job implements Runnable {
//String ip;
//ArrayList <PC>al=new ArrayList<>();
//
//    Job(String ip){
//    this.ip=ip;
//        System.out.println(ip);
//}
//    @Override
//    public void run() {
//            try {
//            
//            //    System.out.println(Credentials.ip+i);
//            HttpResponse httpres=Unirest.get("http://"+ip+":8000/connect")
//           .asString();
//            if(httpres.getStatus()==200){
//                String s=httpres.getBody().toString();
//                System.out.println(s);
////                if(s1.equals("ok")){
////                    String os=st.nextToken();
//                    al.add(new PC(ip,s));
//                    System.out.println("ArrayList:"+al.size());
////                }
//            }
//            
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//    
//}
