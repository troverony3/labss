package com.company;

import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.correlation.Covariance;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Calculate {
    public static final double INTERVAL = 0.95;
    private LinkedHashMap<String, List<Double>> lhm = new LinkedHashMap<>();

    public Calculate() {

    }

    public void CG(Excel ex) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> listvalue = ex.getlistvalue();//все колонки
        for (List<Double> column : listvalue) {     //для кажд колонки из все колонок
            double[] doubles = new double[column.size()];//создали новый массив
            for (int i = 0; i < doubles.length; i++) {
                doubles[i] = column.get(i);//переносим значения из коллекции в массив
            }

            result.add(StatUtils.geometricMean(doubles));
        }
        lhm.put("среднее геометрическое", result);

    }

    public void CA(Excel ex) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> listvalue = ex.getlistvalue();//все колонки
        for (List<Double> column : listvalue) {     //для кажд колонки из все колонок
            double[] doubles = new double[column.size()];
            for (int i = 0; i < doubles.length; i++) {
                doubles[i] = column.get(i);
            }

            result.add(StatUtils.mean(doubles));
        }
        lhm.put("среднее арифметическое", result);
    }

    public void OCO(Excel ex) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> listvalue = ex.getlistvalue();//все колонки
        for (List<Double> column : listvalue) {     //для кажд колонки из все колонок
            double[] doubles = new double[column.size()];
            for (int i = 0; i < doubles.length; i++) {
                doubles[i] = column.get(i);
            }

            result.add(Math.sqrt(StatUtils.variance(doubles)));
        }
        lhm.put("Оценка стандартного отклонения", result);
    }


    public void RV(Excel ex) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> listvalue = ex.getlistvalue();//все колонки
        for (List<Double> column : listvalue) {     //для кажд колонки из все колонок
            double[] doubles = new double[column.size()];
            for (int i = 0; i < doubles.length; i++) {
                doubles[i] = column.get(i);
            }
            result.add(StatUtils.max(doubles) - StatUtils.min(doubles));
        }
        lhm.put("Размах выборки", result);
    }

    public void KK(Excel ex) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> listvalue = ex.getlistvalue();//все колонки
        for (List<Double> column : listvalue) {     //для кажд колонки из все колонок
            double[] doublesa = new double[column.size()];
            for (int i = 0; i < doublesa.length; i++) {
                doublesa[i] = column.get(i);
            }
            for (List<Double> columnb : listvalue) {
                if (!columnb.equals(column)) {          //сравниваем колонки по значению
                    double[] doublesb = new double[columnb.size()];
                    for (int i = 0; i < doublesb.length; i++) {
                        doublesb[i] = columnb.get(i);
                    }
                    result.add(new Covariance().covariance(doublesa, doublesb));
                }


            }
        }
        lhm.put("Коэффициент ковариации", result);
    }

    public void CE(Excel ex) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> listvalue = ex.getlistvalue();//все колонки
        for (List<Double> column : listvalue) {
            result.add((double) column.size());
        }
        lhm.put("Количество элементов", result);
    }


    public void KV(Excel ex) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> listvalue = ex.getlistvalue();//все колонки
        for (List<Double> column : listvalue) {     //для кажд колонки из все колонок
            double[] doubles = new double[column.size()];
            for (int i = 0; i < doubles.length; i++) {
                doubles[i] = column.get(i);
            }
            result.add(Math.sqrt(StatUtils.variance(doubles)) / Math.abs(StatUtils.mean(doubles)));
        }
        lhm.put("Коэффициент вариации", result);
    }


    public void DI1(Excel ex) {

        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> listvalue = ex.getlistvalue();//все колонки
        for (List<Double> column : listvalue) {     //для кажд колонки из все колонок
            double[] doubles = new double[column.size()];
            for (int i = 0; i < doubles.length; i++) {
                doubles[i] = column.get(i);
            }
            result.add(StatUtils.mean(doubles) - (new TDistribution(doubles.length - 1).inverseCumulativeProbability(INTERVAL) * Math.sqrt(StatUtils.variance(doubles))) / Math.sqrt(doubles.length));
        }
        lhm.put("Дов интервал-", result);
    }


    public void DI2(Excel ex) {

        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> listvalue = ex.getlistvalue();//все колонки
        for (List<Double> column : listvalue) {     //для кажд колонки из все колонок
            double[] doubles = new double[column.size()];
            for (int i = 0; i < doubles.length; i++) {
                doubles[i] = column.get(i);
            }
            result.add(StatUtils.mean(doubles) + (new TDistribution(doubles.length - 1).inverseCumulativeProbability(INTERVAL) * Math.sqrt(StatUtils.variance(doubles))) / Math.sqrt(doubles.length));
        }
        lhm.put("Дов интервал+", result);
    }


    public void OD(Excel ex) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> listvalue = ex.getlistvalue();//все колонки
        for (List<Double> column : listvalue) {     //для кажд колонки из все колонок
            double[] doubles = new double[column.size()];
            for (int i = 0; i < doubles.length; i++) {
                doubles[i] = column.get(i);
            }

            result.add(StatUtils.variance(doubles));
        }
        lhm.put("Оценка дисперсии", result);
    }


    public void Max(Excel ex) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> listvalue = ex.getlistvalue();//все колонки
        for (List<Double> column : listvalue) {     //для кажд колонки из все колонок
            double[] doubles = new double[column.size()];
            for (int i = 0; i < doubles.length; i++) {
                doubles[i] = column.get(i);
            }

            result.add(StatUtils.max(doubles));
        }
        lhm.put("Максимум", result);
    }


    public void Min(Excel ex) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> listvalue = ex.getlistvalue();//все колонки
        for (List<Double> column : listvalue) {     //для кажд колонки из все колонок
            double[] doubles = new double[column.size()];
            for (int i = 0; i < doubles.length; i++) {
                doubles[i] = column.get(i);
            }

            result.add(StatUtils.min(doubles));
        }
        lhm.put("Минимум", result);
    }


    public void calc(Excel ex) {

        try {
            CG(ex);
            CA(ex);
            OCO(ex);
            RV(ex);
            KK(ex);
            CE(ex);
            KV(ex);
            DI1(ex);
            DI2(ex);
            OD(ex);
            Max(ex);
            Min(ex);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Данные не записаны", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }

    }


    public LinkedHashMap<String, List<Double>> getresult() {
        return this.lhm;
    }
}
