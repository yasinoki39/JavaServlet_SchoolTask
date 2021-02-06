public class BankTest {
    public static void main(String[] args){
        int num; //返り値を入れる変数
        Bank bank = new Bank(); //インスタンス化

        //BankTest |
        //         V
        System.out.println("BankTest");
        num=bank.open("太郎");//open return 0
        if(num==0){
          System.out.println("戻り値が"+num+"で正常に開設");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.open("太郎");//open return -7
        if(num==-7){
          System.out.println("同じ名前の口座を開こうとして正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance return 0
        if(num==0){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }

        num=bank.deposit("太郎","4000");//deposit return 0
        if(num==0){
          System.out.println("戻り値が"+num+"で正常に4000円預金できました");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance 4000
        if(num==4000){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }

        num=bank.deposit("太郎","-4000");//deposit return -3
        if(num==-3){
          System.out.println("不正な金額で正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance 4000
        if(num==4000){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }

        num=bank.deposit("太郎","0");//deposit return -3
        if(num==-3){
          System.out.println("不正な金額で正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance 4000
        if(num==4000){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }

        num=bank.deposit("太郎","四千");//deposit return -4
        if(num==-4){
          System.out.println("整数でなくて正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance return 4000
        if(num==4000){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }

        num=bank.deposit("名無し","4000");//deposit return -7
        if(num==-7){
          System.out.println("存在しない口座に預金し正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance return 4000
        if(num==4000){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }
        
        num=bank.deposit("名無し","-4000");//deposit return -7
        if(num==-7){
          System.out.println("存在しない口座に預金+不正な金額で正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance return 4000
        if(num==4000){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }

        num=bank.deposit("名無し","四千");//deposit return -7
        if(num==-7){
          System.out.println("存在しない口座に預金+整数でなくて正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance return 4000
        if(num==4000){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }

        num=bank.withdraw("太郎","2000");//withdraw return 0
        if(num==0){
          System.out.println("戻り値が"+num+"で正常に2000円引き出しできました");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance 2000
        if(num==2000){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }

        num=bank.withdraw("太郎","10000");//withdraw return -1
        if(num==-1){
          System.out.println("引き出し額が残高より高く正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance 2000
        if(num==2000){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }
        
        num=bank.withdraw("太郎","-2000");//withdraw return -3
        if(num==-3){
          System.out.println("不正な金額で正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance 2000
        if(num==2000){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }

        num=bank.withdraw("太郎","0");//withdraw return -3
        if(num==-3){
          System.out.println("不正な金額で正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance 2000
        if(num==2000){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }

        num=bank.withdraw("太郎","二千");//withdraw return -4
        if(num==-4){
          System.out.println("整数でなくて正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance 2000
        if(num==2000){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }
        
        num=bank.withdraw("名無し","2000");//withdraw return -7
        if(num==-7){
          System.out.println("存在しない口座に引き出しをして正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance 2000
        if(num==2000){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }
        
        num=bank.withdraw("名無し","10000");//withdraw return -7
        if(num==-7){
          System.out.println("存在しない口座に引き出し+引き出し学が残高より高く正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance 2000
        if(num==2000){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }

        num=bank.withdraw("名無し","-2000");//withdraw return -7
        if(num==-7){
          System.out.println("存在しない口座に引き出し+不正な金額で正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance 2000
        if(num==2000){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }
        
        num=bank.withdraw("名無し","二千");//withdraw return -7
        if(num==-7){
          System.out.println("存在しない口座に引き出し+整数でなくて正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance 2000
        if(num==2000){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }

        num=bank.close("太郎");//close return -1
        if(num==-1){
          System.out.println("残高がある口座を解約しようとして正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance 2000
        if(num==2000){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }

        num=bank.withdraw("太郎","2000");//withdraw return 0
        if(num==0){
          System.out.println("戻り値が"+num+"で正常に2000円引き出しできました");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance 0
        if(num==0){
          System.out.println("残高が"+num+"円で正常");
        }else{
          System.out.println("残高が"+num+"で異常です");
        }

        num=bank.close("太郎");//close return 0
        if(num==0){
          System.out.println("戻り値が"+num+"で正常に解約");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.close("太郎");//close return -7
        if(num==-7){
          System.out.println("リストにない口座を解約して正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }

        num=bank.showBalance("太郎");//showBalance -7
        if(num==-7){
          System.out.println("リストにない口座を残高照会して正常");
        }else{
          System.out.println("戻り値が"+num+"で異常です");
        }
    } 
}
