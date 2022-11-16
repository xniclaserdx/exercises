public class Commit extends ListFiles implements Modifying {

    public Commit(VCS vcs) {
        super(vcs);
    }

    @Override
    public void execute() {
        String newBackupPath = Util.appendFileOrDirname(vcs.getBackupDir(),Util.getTimestamp());
        Util.mkdir(newBackupPath);

        for (String backupfiles : Util.listFiles(vcs.getBackupDir())) {
            Util.moveFile(Util.appendFileOrDirname(vcs.getBackupDir(), backupfiles),
                    Util.appendFileOrDirname(newBackupPath, backupfiles));
        }

        for (String files : Util.listFiles(vcs.getRootDir()))
            Util.copyFile(Util.appendFileOrDirname(vcs.getRootDir(), files),
                    Util.appendFileOrDirname(vcs.getBackupDir(), files));

        System.out.println("Committed the following files:");
        super.execute();
    }

    @Override
    public String getInformation() {
        return "This command does the following modifying operations: \n Files: Copy and Move \n Directory: create";
    }

}
