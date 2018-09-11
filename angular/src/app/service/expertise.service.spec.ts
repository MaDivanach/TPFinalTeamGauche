import { TestBed } from '@angular/core/testing';

import { ExpertiseService } from './expertise.service';

describe('ExpertiseService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ExpertiseService = TestBed.get(ExpertiseService);
    expect(service).toBeTruthy();
  });
});
