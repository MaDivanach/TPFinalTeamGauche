import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpertiseEditComponent } from './expertise-edit.component';

describe('ExpertiseEditComponent', () => {
  let component: ExpertiseEditComponent;
  let fixture: ComponentFixture<ExpertiseEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExpertiseEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExpertiseEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
