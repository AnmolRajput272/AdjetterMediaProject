#include<bits/stdc++.h>
#define s(i) string(1,i)
using namespace std;

int main() {
    string s[] = {"Id","From_number","Start_time","End_time","Duration"};
    int i=0; string s1;
    string JSON_String = "";
    JSON_String+="[ \n";
    while(cin>>s1){
     if(!i) JSON_String+="\t { \n";
     string s2;
     if(i==2 || i==3) cin>>s2;
     JSON_String+="\t \t "+s(char(34))+s[i]+s(char(34))+" : "+s(char(34))+s1;
     if(i==2 || i==3) JSON_String+=" "+s2;
     JSON_String+=s(char(34))+((i+1==5) ? " " : ",");
     JSON_String+="\n";
     i++; i%=5;
     if(!i) JSON_String+=" \t } , \n\n";
    } JSON_String.erase(JSON_String.find_last_of(','));
    JSON_String+="\n ]";
    
    cout<<JSON_String;
}
