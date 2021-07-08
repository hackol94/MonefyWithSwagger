import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
    stages: [
        { duration: '30s', target: 20 },
        { duration: '1m', target: 100 },
        { duration: '1m', target: 100 },
        { duration: '1m', target: 100 },
        { duration: '1m', target: 100 },
        { duration: '30s', target: 0 },
    ],
    thresholds: {
        http_req_failed: ['rate<0.01'],
        http_req_duration: ['p(95)<200'],

    },
};

export default function() {
    let params = { headers: { 'Content-Type': 'application/json' } };
    let data = {
        "id": 10,
        "petId": 198772,
        "quantity": 7,
        "shipDate": "2021-07-07T22:25:10.175Z",
        "status": "approved",
        "complete": true
    };

    let res = http.post('http://localhost:8080/api/v3/store/order', params, JSON.stringify(data));
    check(res, { 'status was 200': (r) => r.status == 200 });
    sleep(1);
}