package Entity;

import Framework.Anotations.DependedField;
import Framework.Anotations.IsAutoIncrement;
import Framework.Anotations.IsSimpleType;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Маринг: преподаватель - предмет - группа.
 */
@Entity
public class StudySubjectMapping extends BaseEntity {

    @Column(name = "id")
    @IsSimpleType
    @IsAutoIncrement
    private int id;

    @DependedField(idColumn = "groupId")
    private Group group;

    @Column(name = "groupId")
    @IsSimpleType
    private int groupId;

    @DependedField(idColumn = "teacherId")
    private Teacher teacher;

    @Column(name = "teacherId")
    @IsSimpleType
    private int teacherId;

    @DependedField(idColumn = "studySubjectId")
    private StudySubject studySubject;

    @Column(name = "studySubjectId")
    @IsSimpleType
    private int studySubjectId;

    @Column(name = "isDeleted")
    @IsSimpleType
    private boolean isDeleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        setGroupId(group.getId());
        this.group = group;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        setTeacherId(teacher.getId());
        this.teacher = teacher;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public StudySubject getStudySubject() {
        return studySubject;
    }

    public void setStudySubject(StudySubject studySubject) {
        setStudySubjectId(studySubject.getId());
        this.studySubject = studySubject;
    }

    public int getStudySubjectId() {
        return studySubjectId;
    }

    public void setStudySubjectId(int studySubjectId) {
        this.studySubjectId = studySubjectId;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    @Override
    public String getTableName() {
        return "StudySubjectMapping";
    }
}
