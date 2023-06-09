package ru.skypro.lessons.springboot.webLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.skypro.lessons.springboot.webLibrary.domains.entity.Report;
import ru.skypro.lessons.springboot.webLibrary.models.projections.ReportInfo;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report,Integer> {
    @Query("SELECT new ru.skypro.lessons.springboot.webLibrary.models.projections.ReportInfo (COALESCE(p.name, 'Workers without position'), COUNT(e), MAX(e.salary), MIN(e.salary), AVG(e.salary)) " +
            "FROM Employee e LEFT JOIN e.position p GROUP BY COALESCE(p.name, 'Workers without position')")
    List<ReportInfo> getReportInfo();
}
