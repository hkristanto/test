package thesis.rwthswc.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Logic {
	/**
	 * 
	 * @param godClassMessage
	 * @param messageCompare
	 * @return
	 * 
	 *         check whether it is a god class or not
	 */
	public static Boolean isGodClass(String godClassMessage,
			String messageCompare) {
		godClassMessage = godClassMessage.toLowerCase();
		messageCompare = messageCompare.toLowerCase();

		if (messageCompare.contains(godClassMessage))
			return true;
		return false;
	}

	/**
	 * 
	 * @param change
	 * @param log
	 * @return
	 * 
	 *         change is equal to insertions (to detect insert) and change is
	 *         equal to deletions (to detect delete)
	 */
	public static int getChanges(String change, String log) {
		String[] tempResult = log.split(",");
		for (String result : tempResult) {
			if (result.contains(change)) {
				return Integer.parseInt(result.substring(1,
						result.lastIndexOf(' ')));
			}
		}
		return 0;
	}

	/**
	 * 
	 * @param root
	 *            delete github lock files
	 */
	public static void deleteIndexLockGithubFiles(String root) {
		List<String> command = OperatingSystem.returnDeleteCommandForGitLock();
		ProcessBuilder pb = new ProcessBuilder();
		pb.command(command);
		pb.directory(new File(root));
		try {
			Process process = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					process.getErrorStream()));
			String result = "";
			while ((result = br.readLine()) != null) {
				System.out.println(result);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * used to override the post-commit
	 */
	public static void setPostCommitScript() {
		List<String> command = new ArrayList<String>();
		ProcessBuilder pb = new ProcessBuilder();
	}
}
