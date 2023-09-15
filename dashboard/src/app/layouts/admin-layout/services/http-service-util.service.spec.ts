import { TestBed } from '@angular/core/testing';

import { HttpServiceUtilService } from './http-service-util.service';

describe('HttpServiceUtilService', () => {
  let service: HttpServiceUtilService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpServiceUtilService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
