public final class Exit extends Command {
    public Exit(VCS vcs) {
        super(vcs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void execute() {
        Util.exit();
    }
}