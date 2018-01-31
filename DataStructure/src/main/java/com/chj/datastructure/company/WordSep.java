package com.chj.datastructure.company;

/**
 * Created by chenhaojie on 2018/01/29.
 */
public class WordSep {
    public static void main(String []args){
        String article = "一篇很长很长的文章";//文章
        int currFlag = 0;//下标
        int bufferSize = 100;//每次工作

        while(currFlag < article.length()){

            String sentence = article.substring(currFlag,currFlag + bufferSize);
            String sentenceTemp = sentence;

            while (sentenceTemp.length() > 0){
                if(sentenceTemp == "词典表的一个词"){
                    //TODO:把当前词添加到分词结果中
                    currFlag += sentenceTemp.length();
                }else {
                    sentenceTemp = sentenceTemp.substring(0,sentence.length() - 1);
                }
            }
            currFlag += bufferSize;
        }

    }
}
