package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.wearable.DataEvent;

public class SwipeRefreshLayout extends ViewGroup {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    private static final int CIRCLE_BG_LIGHT = -328966;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS;
    private static final String LOG_TAG;
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private int mCircleHeight;
    private CircleImageView mCircleView;
    private int mCircleViewIndex;
    private int mCircleWidth;
    private int mCurrentTargetOffsetTop;
    private final DecelerateInterpolator mDecelerateInterpolator;
    protected int mFrom;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private boolean mNotify;
    private boolean mOriginalOffsetCalculated;
    protected int mOriginalOffsetTop;
    private MaterialProgressDrawable mProgress;
    private AnimationListener mRefreshListener;
    private boolean mRefreshing;
    private boolean mReturningToStart;
    private boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    private float mSpinnerFinalOffset;
    private float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private int mTouchSlop;
    private boolean mUsingCustomStart;

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.1 */
    class C00741 implements AnimationListener {
        C00741() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (SwipeRefreshLayout.this.mRefreshing) {
                SwipeRefreshLayout.this.mProgress.setAlpha(SwipeRefreshLayout.MAX_ALPHA);
                SwipeRefreshLayout.this.mProgress.start();
                if (SwipeRefreshLayout.this.mNotify && SwipeRefreshLayout.this.mListener != null) {
                    SwipeRefreshLayout.this.mListener.onRefresh();
                }
            } else {
                SwipeRefreshLayout.this.mProgress.stop();
                SwipeRefreshLayout.this.mCircleView.setVisibility(8);
                SwipeRefreshLayout.this.setColorViewAlpha(SwipeRefreshLayout.MAX_ALPHA);
                if (SwipeRefreshLayout.this.mScale) {
                    SwipeRefreshLayout.this.setAnimationProgress(0.0f);
                } else {
                    SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(SwipeRefreshLayout.this.mOriginalOffsetTop - SwipeRefreshLayout.this.mCurrentTargetOffsetTop, true);
                }
            }
            SwipeRefreshLayout.this.mCurrentTargetOffsetTop = SwipeRefreshLayout.this.mCircleView.getTop();
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.2 */
    class C00752 extends Animation {
        C00752() {
        }

        public void applyTransformation(float interpolatedTime, Transformation t) {
            SwipeRefreshLayout.this.setAnimationProgress(interpolatedTime);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.3 */
    class C00763 extends Animation {
        C00763() {
        }

        public void applyTransformation(float interpolatedTime, Transformation t) {
            SwipeRefreshLayout.this.setAnimationProgress(TextTrackStyle.DEFAULT_FONT_SCALE - interpolatedTime);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.4 */
    class C00774 extends Animation {
        final /* synthetic */ int val$endingAlpha;
        final /* synthetic */ int val$startingAlpha;

        C00774(int i, int i2) {
            this.val$startingAlpha = i;
            this.val$endingAlpha = i2;
        }

        public void applyTransformation(float interpolatedTime, Transformation t) {
            SwipeRefreshLayout.this.mProgress.setAlpha((int) (((float) this.val$startingAlpha) + (((float) (this.val$endingAlpha - this.val$startingAlpha)) * interpolatedTime)));
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.5 */
    class C00785 implements AnimationListener {
        C00785() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (!SwipeRefreshLayout.this.mScale) {
                SwipeRefreshLayout.this.startScaleDownAnimation(null);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.6 */
    class C00796 extends Animation {
        C00796() {
        }

        public void applyTransformation(float interpolatedTime, Transformation t) {
            int endTarget;
            if (SwipeRefreshLayout.this.mUsingCustomStart) {
                endTarget = (int) SwipeRefreshLayout.this.mSpinnerFinalOffset;
            } else {
                endTarget = (int) (SwipeRefreshLayout.this.mSpinnerFinalOffset - ((float) Math.abs(SwipeRefreshLayout.this.mOriginalOffsetTop)));
            }
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((SwipeRefreshLayout.this.mFrom + ((int) (((float) (endTarget - SwipeRefreshLayout.this.mFrom)) * interpolatedTime))) - SwipeRefreshLayout.this.mCircleView.getTop(), false);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.7 */
    class C00807 extends Animation {
        C00807() {
        }

        public void applyTransformation(float interpolatedTime, Transformation t) {
            SwipeRefreshLayout.this.moveToStart(interpolatedTime);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.8 */
    class C00818 extends Animation {
        C00818() {
        }

        public void applyTransformation(float interpolatedTime, Transformation t) {
            SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.mStartingScale + ((-SwipeRefreshLayout.this.mStartingScale) * interpolatedTime));
            SwipeRefreshLayout.this.moveToStart(interpolatedTime);
        }
    }

    public interface OnRefreshListener {
        void onRefresh();
    }

    static {
        LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
        int[] iArr = new int[DEFAULT];
        iArr[LARGE] = 16842766;
        LAYOUT_ATTRS = iArr;
    }

    private void setColorViewAlpha(int targetAlpha) {
        this.mCircleView.getBackground().setAlpha(targetAlpha);
        this.mProgress.setAlpha(targetAlpha);
    }

    public void setProgressViewOffset(boolean scale, int start, int end) {
        this.mScale = scale;
        this.mCircleView.setVisibility(8);
        this.mCurrentTargetOffsetTop = start;
        this.mOriginalOffsetTop = start;
        this.mSpinnerFinalOffset = (float) end;
        this.mUsingCustomStart = true;
        this.mCircleView.invalidate();
    }

    public void setProgressViewEndTarget(boolean scale, int end) {
        this.mSpinnerFinalOffset = (float) end;
        this.mScale = scale;
        this.mCircleView.invalidate();
    }

    public void setSize(int size) {
        if (size == 0 || size == DEFAULT) {
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            int i;
            if (size == 0) {
                i = (int) (56.0f * metrics.density);
                this.mCircleWidth = i;
                this.mCircleHeight = i;
            } else {
                i = (int) (40.0f * metrics.density);
                this.mCircleWidth = i;
                this.mCircleHeight = i;
            }
            this.mCircleView.setImageDrawable(null);
            this.mProgress.updateSizes(size);
            this.mCircleView.setImageDrawable(this.mProgress);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mRefreshing = false;
        this.mTotalDragDistance = GroundOverlayOptions.NO_DIMENSION;
        this.mOriginalOffsetCalculated = false;
        this.mActivePointerId = INVALID_POINTER;
        this.mCircleViewIndex = INVALID_POINTER;
        this.mRefreshListener = new C00741();
        this.mAnimateToCorrectPosition = new C00796();
        this.mAnimateToStartPosition = new C00807();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(DECELERATE_INTERPOLATION_FACTOR);
        TypedArray a = context.obtainStyledAttributes(attrs, LAYOUT_ATTRS);
        setEnabled(a.getBoolean(LARGE, true));
        a.recycle();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        this.mCircleWidth = (int) (metrics.density * 40.0f);
        this.mCircleHeight = (int) (metrics.density * 40.0f);
        createProgressView();
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.mSpinnerFinalOffset = 64.0f * metrics.density;
        this.mTotalDragDistance = this.mSpinnerFinalOffset;
    }

    protected int getChildDrawingOrder(int childCount, int i) {
        if (this.mCircleViewIndex < 0) {
            return i;
        }
        if (i == childCount + INVALID_POINTER) {
            return this.mCircleViewIndex;
        }
        if (i >= this.mCircleViewIndex) {
            return i + DEFAULT;
        }
        return i;
    }

    private void createProgressView() {
        this.mCircleView = new CircleImageView(getContext(), CIRCLE_BG_LIGHT, 20.0f);
        this.mProgress = new MaterialProgressDrawable(getContext(), this);
        this.mProgress.setBackgroundColor(CIRCLE_BG_LIGHT);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
    }

    public void setOnRefreshListener(OnRefreshListener listener) {
        this.mListener = listener;
    }

    private boolean isAlphaUsedForScale() {
        return VERSION.SDK_INT < 11;
    }

    public void setRefreshing(boolean refreshing) {
        if (!refreshing || this.mRefreshing == refreshing) {
            setRefreshing(refreshing, false);
            return;
        }
        int endTarget;
        this.mRefreshing = refreshing;
        if (this.mUsingCustomStart) {
            endTarget = (int) this.mSpinnerFinalOffset;
        } else {
            endTarget = (int) (this.mSpinnerFinalOffset + ((float) this.mOriginalOffsetTop));
        }
        setTargetOffsetTopAndBottom(endTarget - this.mCurrentTargetOffsetTop, true);
        this.mNotify = false;
        startScaleUpAnimation(this.mRefreshListener);
    }

    private void startScaleUpAnimation(AnimationListener listener) {
        this.mCircleView.setVisibility(LARGE);
        if (VERSION.SDK_INT >= 11) {
            this.mProgress.setAlpha(MAX_ALPHA);
        }
        this.mScaleAnimation = new C00752();
        this.mScaleAnimation.setDuration((long) this.mMediumAnimationDuration);
        if (listener != null) {
            this.mCircleView.setAnimationListener(listener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    private void setAnimationProgress(float progress) {
        if (isAlphaUsedForScale()) {
            setColorViewAlpha((int) (255.0f * progress));
            return;
        }
        ViewCompat.setScaleX(this.mCircleView, progress);
        ViewCompat.setScaleY(this.mCircleView, progress);
    }

    private void setRefreshing(boolean refreshing, boolean notify) {
        if (this.mRefreshing != refreshing) {
            this.mNotify = notify;
            ensureTarget();
            this.mRefreshing = refreshing;
            if (this.mRefreshing) {
                animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
            } else {
                startScaleDownAnimation(this.mRefreshListener);
            }
        }
    }

    private void startScaleDownAnimation(AnimationListener listener) {
        this.mScaleDownAnimation = new C00763();
        this.mScaleDownAnimation.setDuration(150);
        this.mCircleView.setAnimationListener(listener);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), STARTING_PROGRESS_ALPHA);
    }

    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), MAX_ALPHA);
    }

    private Animation startAlphaAnimation(int startingAlpha, int endingAlpha) {
        if (this.mScale && isAlphaUsedForScale()) {
            return null;
        }
        Animation alpha = new C00774(startingAlpha, endingAlpha);
        alpha.setDuration(300);
        this.mCircleView.setAnimationListener(null);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(alpha);
        return alpha;
    }

    public void setProgressBackgroundColor(int colorRes) {
        this.mCircleView.setBackgroundColor(colorRes);
        this.mProgress.setBackgroundColor(getResources().getColor(colorRes));
    }

    @Deprecated
    public void setColorScheme(int... colors) {
        setColorSchemeResources(colors);
    }

    public void setColorSchemeResources(int... colorResIds) {
        Resources res = getResources();
        int[] colorRes = new int[colorResIds.length];
        for (int i = LARGE; i < colorResIds.length; i += DEFAULT) {
            colorRes[i] = res.getColor(colorResIds[i]);
        }
        setColorSchemeColors(colorRes);
    }

    public void setColorSchemeColors(int... colors) {
        ensureTarget();
        this.mProgress.setColorSchemeColors(colors);
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            int i = LARGE;
            while (i < getChildCount()) {
                View child = getChildAt(i);
                if (child.equals(this.mCircleView)) {
                    i += DEFAULT;
                } else {
                    this.mTarget = child;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int distance) {
        this.mTotalDragDistance = (float) distance;
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.mTarget == null) {
                ensureTarget();
            }
            if (this.mTarget != null) {
                View child = this.mTarget;
                int childLeft = getPaddingLeft();
                int childTop = getPaddingTop();
                child.layout(childLeft, childTop, childLeft + ((width - getPaddingLeft()) - getPaddingRight()), childTop + ((height - getPaddingTop()) - getPaddingBottom()));
                int circleWidth = this.mCircleView.getMeasuredWidth();
                this.mCircleView.layout((width / 2) - (circleWidth / 2), this.mCurrentTargetOffsetTop, (width / 2) + (circleWidth / 2), this.mCurrentTargetOffsetTop + this.mCircleView.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.mTarget == null) {
            ensureTarget();
        }
        if (this.mTarget != null) {
            this.mTarget.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.mCircleView.measure(MeasureSpec.makeMeasureSpec(this.mCircleWidth, 1073741824), MeasureSpec.makeMeasureSpec(this.mCircleHeight, 1073741824));
            if (!(this.mUsingCustomStart || this.mOriginalOffsetCalculated)) {
                this.mOriginalOffsetCalculated = true;
                int i = -this.mCircleView.getMeasuredHeight();
                this.mOriginalOffsetTop = i;
                this.mCurrentTargetOffsetTop = i;
            }
            this.mCircleViewIndex = INVALID_POINTER;
            for (int index = LARGE; index < getChildCount(); index += DEFAULT) {
                if (getChildAt(index) == this.mCircleView) {
                    this.mCircleViewIndex = index;
                    return;
                }
            }
        }
    }

    public boolean canChildScrollUp() {
        if (VERSION.SDK_INT >= 14) {
            return ViewCompat.canScrollVertically(this.mTarget, INVALID_POINTER);
        }
        if (this.mTarget instanceof AbsListView) {
            AbsListView absListView = this.mTarget;
            if (absListView.getChildCount() <= 0 || (absListView.getFirstVisiblePosition() <= 0 && absListView.getChildAt(LARGE).getTop() >= absListView.getPaddingTop())) {
                return false;
            }
            return true;
        } else if (this.mTarget.getScrollY() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        ensureTarget();
        int action = MotionEventCompat.getActionMasked(ev);
        if (this.mReturningToStart && action == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing) {
            return false;
        }
        switch (action) {
            case LARGE /*0*/:
                setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop(), true);
                this.mActivePointerId = MotionEventCompat.getPointerId(ev, LARGE);
                this.mIsBeingDragged = false;
                float initialMotionY = getMotionEventY(ev, this.mActivePointerId);
                if (initialMotionY != GroundOverlayOptions.NO_DIMENSION) {
                    this.mInitialMotionY = initialMotionY;
                    break;
                }
                return false;
            case DEFAULT /*1*/:
            case DetectedActivity.STILL /*3*/:
                this.mIsBeingDragged = false;
                this.mActivePointerId = INVALID_POINTER;
                break;
            case DataEvent.TYPE_DELETED /*2*/:
                break;
            case Quest.STATE_FAILED /*6*/:
                onSecondaryPointerUp(ev);
                break;
        }
        if (this.mActivePointerId == INVALID_POINTER) {
            Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
            return false;
        }
        float y = getMotionEventY(ev, this.mActivePointerId);
        if (y == GroundOverlayOptions.NO_DIMENSION) {
            return false;
        }
        if (y - this.mInitialMotionY > ((float) this.mTouchSlop) && !this.mIsBeingDragged) {
            this.mIsBeingDragged = true;
            this.mProgress.setAlpha(STARTING_PROGRESS_ALPHA);
        }
        return this.mIsBeingDragged;
    }

    private float getMotionEventY(MotionEvent ev, int activePointerId) {
        int index = MotionEventCompat.findPointerIndex(ev, activePointerId);
        if (index < 0) {
            return GroundOverlayOptions.NO_DIMENSION;
        }
        return MotionEventCompat.getY(ev, index);
    }

    public void requestDisallowInterceptTouchEvent(boolean b) {
    }

    private boolean isAnimationRunning(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        int action = MotionEventCompat.getActionMasked(ev);
        if (this.mReturningToStart && action == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp()) {
            return false;
        }
        int pointerIndex;
        float overscrollTop;
        switch (action) {
            case LARGE /*0*/:
                this.mActivePointerId = MotionEventCompat.getPointerId(ev, LARGE);
                this.mIsBeingDragged = false;
                break;
            case DEFAULT /*1*/:
            case DetectedActivity.STILL /*3*/:
                int i = this.mActivePointerId;
                if (r0 == INVALID_POINTER) {
                    if (action == DEFAULT) {
                        Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
                    }
                    return false;
                }
                pointerIndex = MotionEventCompat.findPointerIndex(ev, this.mActivePointerId);
                overscrollTop = (MotionEventCompat.getY(ev, pointerIndex) - this.mInitialMotionY) * DRAG_RATE;
                this.mIsBeingDragged = false;
                if (overscrollTop > this.mTotalDragDistance) {
                    setRefreshing(true, true);
                } else {
                    this.mRefreshing = false;
                    this.mProgress.setStartEndTrim(0.0f, 0.0f);
                    AnimationListener listener = null;
                    if (!this.mScale) {
                        listener = new C00785();
                    }
                    animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, listener);
                    this.mProgress.showArrow(false);
                }
                this.mActivePointerId = INVALID_POINTER;
                return false;
            case DataEvent.TYPE_DELETED /*2*/:
                pointerIndex = MotionEventCompat.findPointerIndex(ev, this.mActivePointerId);
                if (pointerIndex >= 0) {
                    overscrollTop = (MotionEventCompat.getY(ev, pointerIndex) - this.mInitialMotionY) * DRAG_RATE;
                    if (this.mIsBeingDragged) {
                        this.mProgress.showArrow(true);
                        float originalDragPercent = overscrollTop / this.mTotalDragDistance;
                        if (originalDragPercent >= 0.0f) {
                            float slingshotDist;
                            float dragPercent = Math.min(TextTrackStyle.DEFAULT_FONT_SCALE, Math.abs(originalDragPercent));
                            float adjustedPercent = (((float) Math.max(((double) dragPercent) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
                            float extraOS = Math.abs(overscrollTop) - this.mTotalDragDistance;
                            if (this.mUsingCustomStart) {
                                slingshotDist = this.mSpinnerFinalOffset - ((float) this.mOriginalOffsetTop);
                            } else {
                                slingshotDist = this.mSpinnerFinalOffset;
                            }
                            float tensionSlingshotPercent = Math.max(0.0f, Math.min(extraOS, DECELERATE_INTERPOLATION_FACTOR * slingshotDist) / slingshotDist);
                            float tensionPercent = ((float) (((double) (tensionSlingshotPercent / 4.0f)) - Math.pow((double) (tensionSlingshotPercent / 4.0f), 2.0d))) * DECELERATE_INTERPOLATION_FACTOR;
                            float extraMove = (slingshotDist * tensionPercent) * DECELERATE_INTERPOLATION_FACTOR;
                            int targetY = this.mOriginalOffsetTop + ((int) ((slingshotDist * dragPercent) + extraMove));
                            if (this.mCircleView.getVisibility() != 0) {
                                this.mCircleView.setVisibility(LARGE);
                            }
                            if (!this.mScale) {
                                ViewCompat.setScaleX(this.mCircleView, TextTrackStyle.DEFAULT_FONT_SCALE);
                                ViewCompat.setScaleY(this.mCircleView, TextTrackStyle.DEFAULT_FONT_SCALE);
                            }
                            if (overscrollTop < this.mTotalDragDistance) {
                                if (this.mScale) {
                                    setAnimationProgress(overscrollTop / this.mTotalDragDistance);
                                }
                                if (this.mProgress.getAlpha() > STARTING_PROGRESS_ALPHA) {
                                    if (!isAnimationRunning(this.mAlphaStartAnimation)) {
                                        startProgressAlphaStartAnimation();
                                    }
                                }
                                float strokeStart = adjustedPercent * MAX_PROGRESS_ANGLE;
                                this.mProgress.setStartEndTrim(0.0f, Math.min(MAX_PROGRESS_ANGLE, strokeStart));
                                this.mProgress.setArrowScale(Math.min(TextTrackStyle.DEFAULT_FONT_SCALE, adjustedPercent));
                            } else {
                                if (this.mProgress.getAlpha() < MAX_ALPHA) {
                                    if (!isAnimationRunning(this.mAlphaMaxAnimation)) {
                                        startProgressAlphaMaxAnimation();
                                    }
                                }
                            }
                            float rotation = ((-0.25f + (0.4f * adjustedPercent)) + (DECELERATE_INTERPOLATION_FACTOR * tensionPercent)) * DRAG_RATE;
                            this.mProgress.setProgressRotation(rotation);
                            setTargetOffsetTopAndBottom(targetY - this.mCurrentTargetOffsetTop, true);
                            break;
                        }
                        return false;
                    }
                }
                Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
                break;
            case DetectedActivity.TILTING /*5*/:
                this.mActivePointerId = MotionEventCompat.getPointerId(ev, MotionEventCompat.getActionIndex(ev));
                break;
            case Quest.STATE_FAILED /*6*/:
                onSecondaryPointerUp(ev);
                break;
        }
        return true;
    }

    private void animateOffsetToCorrectPosition(int from, AnimationListener listener) {
        this.mFrom = from;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (listener != null) {
            this.mCircleView.setAnimationListener(listener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int from, AnimationListener listener) {
        if (this.mScale) {
            startScaleDownReturnToStartAnimation(from, listener);
            return;
        }
        this.mFrom = from;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (listener != null) {
            this.mCircleView.setAnimationListener(listener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    }

    private void moveToStart(float interpolatedTime) {
        setTargetOffsetTopAndBottom((this.mFrom + ((int) (((float) (this.mOriginalOffsetTop - this.mFrom)) * interpolatedTime))) - this.mCircleView.getTop(), false);
    }

    private void startScaleDownReturnToStartAnimation(int from, AnimationListener listener) {
        this.mFrom = from;
        if (isAlphaUsedForScale()) {
            this.mStartingScale = (float) this.mProgress.getAlpha();
        } else {
            this.mStartingScale = ViewCompat.getScaleX(this.mCircleView);
        }
        this.mScaleDownToStartAnimation = new C00818();
        this.mScaleDownToStartAnimation.setDuration(150);
        if (listener != null) {
            this.mCircleView.setAnimationListener(listener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }

    private void setTargetOffsetTopAndBottom(int offset, boolean requiresUpdate) {
        this.mCircleView.bringToFront();
        this.mCircleView.offsetTopAndBottom(offset);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
        if (requiresUpdate && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void onSecondaryPointerUp(MotionEvent ev) {
        int pointerIndex = MotionEventCompat.getActionIndex(ev);
        if (MotionEventCompat.getPointerId(ev, pointerIndex) == this.mActivePointerId) {
            this.mActivePointerId = MotionEventCompat.getPointerId(ev, pointerIndex == 0 ? DEFAULT : LARGE);
        }
    }
}
