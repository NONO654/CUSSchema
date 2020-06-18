import com.matrixone.apps.domain.util.MqlUtil;
import matrix.db.Context;

import java.io.File;

public class CSDDCProgramJPO_mxJPO {

    public static String PATH = "D:/CUSSchema/LibrarySpinner/Business/SourceFiles";
    public void runProgram(Context context, String[] args) throws Exception{
        File file = new File(PATH);
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if(fileList[i].isFile()) {
                String fileName = fileList[i].getName();
                int index = fileName.indexOf("_");
                String jpoName = fileName.substring(0, index);
                String filePath = PATH+"/"+fileName;
                MqlUtil.mqlCommand(context, "insert prog $1", filePath);
                MqlUtil.mqlCommand(context, "compile prog $1", jpoName);
                System.out.println(jpoName+" is compiled");
            }else if(fileList[i].isDirectory()) {
                String tempPath = PATH+"/"+fileList[i].getName();
                File tempFile = new File(tempPath);
                File[] tempList = tempFile.listFiles();
                for(int j=0; j<tempList.length; j++) {
                    String tempName = tempList[j].getName();
                    String tempFilePath = tempPath+"/"+tempName;
                    int tempIndex = tempName.indexOf("_");
                    String tempJPOName = tempName.substring(0, tempIndex);
                    MqlUtil.mqlCommand(context, "insert prog $1", tempFilePath);
                    MqlUtil.mqlCommand(context, "compile prog $1", tempJPOName);
                    System.out.println(tempJPOName+" is compiled");
                }
            }
        }
    }
}
