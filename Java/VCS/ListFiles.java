public non-sealed class ListFiles extends Command {
    public ListFiles(VCS vcs) {
        super(vcs);
    }

    @Override
    public void execute() {
        for (String files : Util.listFiles(vcs.getRootDir()))
            System.out.println(files);
    }
}
