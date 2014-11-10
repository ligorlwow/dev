package DAOAccessor.Services;

import Entity.StudySubjectMapping;

public class StudySubjectMappingService extends BaseDbService<StudySubjectMapping> {

    public static final StudySubjectMapping Instance = new StudySubjectMapping();

    private StudySubjectMappingService() {
    }

    @Override
    public void setDependedObjects(StudySubjectMapping object) {
        object.setGroup(GroupService.Instance.getById(object.getGroupId()));
        object.setTeacher(TeacherService.Instance.getById(object.getTeacherId()));
        object.setStudySubject(StudySubjectService.Instance.getById(object.getStudySubjectId()));
    }
}
