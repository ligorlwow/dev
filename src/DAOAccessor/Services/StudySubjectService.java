package DAOAccessor.Services;

import Entity.StudySubject;

public class StudySubjectService extends BaseDbService<StudySubject> {
    public static final StudySubjectService Instance = new StudySubjectService();

    private StudySubjectService() {
    }

    @Override
    public void setDependedObjects(StudySubject object) {

    }
}
