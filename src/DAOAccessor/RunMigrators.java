package DAOAccessor;

import DAOAccessor.Migrators.*;
import DAOAccessor.Services.MigratorService;
import Entity.Migrator;
import Framework.LambdaExtensions;

import java.util.*;

/**
 * Миграциия базы - доводим ее до рабочего состояния.
 */
public class RunMigrators {

    public static void tryMigrateIfNeeded() {

        if (!DBUtils.dbExists(DBConstants.DB_NAME)) {
            DBUtils.createDbSafe(DBConstants.DB_NAME);
        }

        // Мигратор старта, его запускаем вручную
        // т.к. он нужен для старта остальных миграторов.
        IRunMigrator createMigrator = new U01CreateMigrator();
        createMigrator.migrate();
        OptionalInt nullAbleMaxNumber = MigratorService.Instance.getAll()
                .stream()
                .mapToInt(p -> p.getNumber())
                .max();
        int maxMigratorNumber = LambdaExtensions.get(nullAbleMaxNumber);

        getAllSortedRegisteredMigrators().stream().filter(m -> m.getNumber() > maxMigratorNumber)
                .forEach(m -> {
                    m.migrate();
                    MigratorService.Instance.add(new Migrator(m.getNumber()));
                });
    }

    private static List<IRunMigrator> getAllSortedRegisteredMigrators() {
        List<IRunMigrator> result = new ArrayList<>();

        result.add(new U01CreateMigrator());
        result.add(new U02AddGroupTable());
        result.add(new U03AddStudentTable());
        result.add(new U04AddStudySubjectTable());
        result.add(new U05AddTeacherTable());
        result.add(new U06AddStudySubjectMapping());

        result.sort(new Comparator<IRunMigrator>() {
            @Override
            public int compare(IRunMigrator o1, IRunMigrator o2) {
                return Integer.compare(o1.getNumber(), o2.getNumber());
            }
        });
        return result;
    }
}
