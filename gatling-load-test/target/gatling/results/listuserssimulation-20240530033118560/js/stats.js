var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name--1146707516",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "3000",
        "ok": "3000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "529",
        "ok": "529",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "13547",
        "ok": "13547",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "6214",
        "ok": "6214",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "3015",
        "ok": "3015",
        "ko": "-"
    },
    "percentiles1": {
        "total": "6657",
        "ok": "6657",
        "ko": "-"
    },
    "percentiles2": {
        "total": "8365",
        "ok": "8365",
        "ko": "-"
    },
    "percentiles3": {
        "total": "10966",
        "ok": "10966",
        "ko": "-"
    },
    "percentiles4": {
        "total": "12477",
        "ok": "12477",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 2,
    "percentage": 0.06666666666666667
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 75,
    "percentage": 2.5
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 2923,
    "percentage": 97.43333333333334
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 0,
    "percentage": 0.0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "187.5",
        "ok": "187.5",
        "ko": "-"
    }
},
contents: {
"req_list-users-869781510": {
        type: "REQUEST",
        name: "List Users",
path: "List Users",
pathFormatted: "req_list-users-869781510",
stats: {
    "name": "List Users",
    "numberOfRequests": {
        "total": "3000",
        "ok": "3000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "529",
        "ok": "529",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "13547",
        "ok": "13547",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "6214",
        "ok": "6214",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "3015",
        "ok": "3015",
        "ko": "-"
    },
    "percentiles1": {
        "total": "6657",
        "ok": "6657",
        "ko": "-"
    },
    "percentiles2": {
        "total": "8365",
        "ok": "8365",
        "ko": "-"
    },
    "percentiles3": {
        "total": "10966",
        "ok": "10966",
        "ko": "-"
    },
    "percentiles4": {
        "total": "12477",
        "ok": "12477",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 2,
    "percentage": 0.06666666666666667
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 75,
    "percentage": 2.5
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 2923,
    "percentage": 97.43333333333334
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 0,
    "percentage": 0.0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "187.5",
        "ok": "187.5",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
