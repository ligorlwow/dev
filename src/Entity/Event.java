package Entity;

import Framework.Anotations.DependedField;
import Framework.Anotations.IsAutoIncrement;
import Framework.Anotations.IsSimpleType;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;

/**
 * Соыбтие - пара.
 */
@Entity
public class Event extends BaseEntity {

    @Column(name = "id")
    @IsSimpleType
    @IsAutoIncrement
    private int id;

    @DependedField(idColumn = "teacherId")
    private Teacher teacher;

    @Column(name = "teacherId")
    @IsSimpleType
    private int teacherId;

    @DependedField(idColumn = "groupId")
    private Group group;

    @Column(name = "groupId")
    @IsSimpleType
    private int groupId;

    @DependedField(idColumn = "classRoomId")
    private ClassRoom classRoom;

    @Column(name = "classRoomId")
    @IsSimpleType
    private int classRoomId;

    @DependedField(idColumn = "studySubjectId")
    private StudySubject studySubject;

    @Column(name = "studySubjectId")
    @IsSimpleType
    private int studySubjectId;

    /**
     * Начало события.
     */
    @Column(name = "startDate")
    private Timestamp startDate;

    /**
     * Конец события.
     */
    @Column(name = "endDate")
    private Timestamp endDate;

    @Column(name = "isDeleted")
    @IsSimpleType
    private boolean isDeleted;

    public Event() {
    }

    public Event(Teacher teacher,
                 Group group,
                 StudySubject studySubject,
                 ClassRoom classRoom,
                 Timestamp endDate,
                 Timestamp startDate) {
        this.teacher = teacher;
        this.teacherId = teacher.getId();
        this.group = group;
        this.groupId = group.getId();
        this.studySubject = studySubject;
        this.studySubjectId = studySubject.getId();
        this.classRoom = classRoom;
        this.classRoomId = classRoom.getId();
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacherId = teacher.getId();
        this.teacher = teacher;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.groupId = group.getId();
        this.group = group;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoomId = classRoom.getId();
        this.classRoom = classRoom;
    }

    public int getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(int classRoomId) {
        this.classRoomId = classRoomId;
    }

    public StudySubject getStudySubject() {
        return studySubject;
    }

    public void setStudySubject(StudySubject studySubject) {
        this.studySubjectId = studySubject.getId();
        this.studySubject = studySubject;
    }

    public int getStudySubjectId() {
        return studySubjectId;
    }

    public void setStudySubjectId(int studySubjectId) {
        this.studySubjectId = studySubjectId;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String getTableName() {
        return "Event";
    }
}
